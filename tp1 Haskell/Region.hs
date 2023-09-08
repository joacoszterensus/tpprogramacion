module Region ( Region, newR, foundR, linkR, connectedR, linkedR, delayR,tunelR, availableCapacityForR)
   where

import City
import Tunel
import Link
import Quality
data Region = Reg [City] [Link] [Tunel] deriving (Show)

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) newcity
    | elem newcity cities = Reg cities links tunnels
    | otherwise = Reg (cities ++ [newcity]) links tunnels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunnels) cityA cityB quality 
    | cityA `elem` cities && cityB `elem` cities =
        Reg cities (links ++ [newL cityA cityB quality]) tunnels
    | otherwise = error "No se encuentran ambas ciudades en la region."

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region [] = region 
tunelR region@(Reg cities links tunnels) list 
    | not (checkList list cities) = error "No se encuentran ambas ciudades en la region"
    | length list < 2 = error "No es posible generar un tunel con 1 ciudad."
    | otherwise = Reg cities links ((creationR region list):tunnels)

creationR :: Region -> [City] -> Tunel
creationR region@(Reg cities links tunnels) list 
    | length list == 2 && (availableCapacityForR region (head list) (last list)) > 0
        = shortTunnel links list
    | length list > 2 && capacityCheck region list = largeTunnel links list
    | otherwise = error "Hay un link que no posee la capacidad suficiente para generar un tunel."
    where
        capacityCheck :: Region -> [City] -> Bool
        capacityCheck _ [c] = True
        capacityCheck region (c:cs)
            | availableCapacityForR region c (head cs) > 0 = capacityCheck region cs
            | otherwise = False

checkList :: [City] -> [City] -> Bool
checkList list cities = foldr (\city acc -> city `elem` cities && acc) True list 

shortTunnel :: [Link] -> [City] -> Tunel
shortTunnel [] cities = error "No existe un link que conecte las dos ciudades."
shortTunnel links@(l:ls) cities@[cityA,cityB] 
    | linksL cityA cityB l = newT [l]
    | otherwise = shortTunnel ls cities

largeTunnel :: [Link] -> [City] -> Tunel
largeTunnel links cities
    | validTunnel = tunnel
    | otherwise = error "No hay links que conecten esas ciudades."
    where
        tunnel = buildT [] links cities
        validTunnel = connectsT (head cities) (last cities) (buildT [] links cities)

buildT :: [Link] -> [Link] -> [City] -> Tunel
buildT accLinks [] cities = newT accLinks
buildT accLinks links@(l:ls) cities@(c:cs)
    | length cities == 1 = newT accLinks
    | linksL c (head cs) l = buildT (accLinks ++ [l]) links cs
    | otherwise = buildT accLinks ls cities

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg _ _ tunnels) cityA cityB = foldr (\tunnel acc -> connectsT cityA cityB tunnel || acc) False tunnels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ links _) cityA cityB = foldr (\link acc -> linksL cityA cityB link || acc) False links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg _ _ tuneles) cityA cityB = sumaDelay 
    where
        sumaDelay = findDelay cityA cityB tuneles
findDelay :: City -> City -> [Tunel] -> Float
findDelay _ _ [] = error "No hay una conexion entre esas ciudades."
findDelay cityA cityB (t:ts) 
    | connectsT cityA cityB t = delayT t
    | otherwise = findDelay cityA cityB ts

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR region@(Reg _ links tuneles) cityA cityB 
    | not (linkedR region cityA cityB) = error "No es posible conectar esas ciudades."
    | otherwise = capacidadInicial - cantidadUsada
    where 
        targetLink = (capturarL links cityA cityB)
        capacidadInicial = capacityL targetLink
        cantidadUsada = contador targetLink tuneles
    
contador :: Link -> [Tunel] -> Int
contador targetLink tunnels = foldr (\tunel acc -> acc + fromEnum (usesT targetLink tunel)) 0 tunnels

capturarL :: [Link] -> City -> City -> Link
capturarL (l:ls) cityA cityB 
    | linksL cityA cityB l = l
    | otherwise = capturarL ls cityA cityB
