module Tunel ( Tunel, newT, connectsT, usesT, delayT)
   where
import Link
import City
import Point
import Quality
data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT [] = error "El Tunel no contiene ningun link"
newT links = Tun links
connectsT :: City -> City -> Tunel -> Bool-- indica si éste túnel conecta estas dos ciudades distintas
connectsT cityA cityB (Tun links)
    | null links           = False 
    | length links == 1    = linksL cityA cityB  (head links)
    | otherwise            = (firstVerify cityA cityB links && lastVerify cityA cityB links)

firstVerify :: City -> City -> [Link] -> Bool
firstVerify cityA cityB links = connectsL cityA (head links) && not( connectsL cityA (links !!1)) 
                                 || connectsL cityB (head links) && not( connectsL cityB (links !!1))

lastVerify :: City -> City -> [Link] -> Bool
lastVerify cityA cityB links = connectsL cityA (last links) && not( connectsL cityA (last(init links))) 
                               || connectsL cityB (last links) && not( connectsL cityB (last (init links)))


usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun links) = link `elem` links
 
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel 
delayT (Tun links) = foldr (\link fold -> fold + delayL link) 0.0 links
 
