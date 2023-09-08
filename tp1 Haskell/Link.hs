module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where
import City
import Quality
import Point

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city1 city2 quality = Lin city1 city2 quality
connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city0 (Lin city1 city2 _) | (city0 == city1 || city0 == city2)   = True
                                    |otherwise = False

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL cityA cityB (Lin city1 city2 _) | (cityA==city1 && cityB==city2) || (cityA == city2 && cityB == city1) =True
                                       | otherwise = False
capacityL :: Link -> Int
capacityL (Lin _ _ q) = capacityQ q
delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin _ _ qua)= delayQ qua


