
module City ( City, newC, nameC, distanceC )
   where
import Point
data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC name punto = Cit name punto
nameC :: City -> String
nameC (Cit str pu) = str
distanceC :: City -> City -> Float
distanceC (Cit _ punto1) (Cit _ punto2) = difP punto1 punto2

