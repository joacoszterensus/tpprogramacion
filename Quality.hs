module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ str tuneles demora = Qua str tuneles demora
capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua _ tuneles _) = tuneles
delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua _ _ demora) = demora