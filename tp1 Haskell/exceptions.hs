import Control.Exception
import System.IO.Unsafe
import City
import Point
import Link
import Quality
import Tunel
import Region

-- Points
p1 = newP 2 2
p2 = newP 1 1
p3 = newP 3 3
p4 = newP 1 3
p5 = newP 5 1
p6 = newP 4 9

-- Cities
bsas = newC "bsas" p1
rio = newC "rio" p2
paris = newC "paris" p3
miami = newC "miami" p4
ny = newC "nyc" p5
valencia = newC "val" p6
sa = newC "fr" p3

-- Quality
calidad1 = newQ "C1" 4 3.0
calidad2 = newQ "C2" 2 1.0
calidad3 = newQ "C3" 5 7.5
calidad4 = newQ "C4" 2 5.0

-- Links
link01 = newL bsas rio calidad1 
link02 = newL rio paris calidad2
link03 = newL paris miami calidad3
link04 = newL miami ny calidad4
link05 = newL ny valencia calidad2

-- Tuneles
tunelA = newT [link01,link02,link03]
tunelB = newT [link01,link02,link03,link04]
tunelC = newT [link01,link02]
tunelD = newT [link03,link04,link05]

-- Lista de ciudades 
lista1= [bsas,rio,paris,miami]
lista2= [rio,paris,miami,ny,valencia]
lista3= [paris,miami,ny]
lista4 = [miami,ny,valencia]

r0 = newR 
r1 = foundR r0 bsas
r21 = foundR r1 sa
r2 = foundR r21 paris
r3 = foundR r2 rio
r4 = foundR r3 ny
r5 = foundR r4 valencia
r55 = foundR r5 miami
r6 = linkR r55 bsas rio calidad1
r7 = linkR r6 rio paris calidad2
r8 = linkR r7 paris miami calidad3  
r9 = linkR r8 miami ny calidad4
mundi = linkR r9 ny valencia calidad2

mondo2 = tunelR mundi lista1
mondo3 = tunelR mondo2 lista2
global = tunelR mondo3 lista3
globi = tunelR global lista4


españa = newR
e1 = foundR españa bsas
e2 = foundR e1 paris
e3 = foundR e2 ny
e4 = linkR e3 bsas ny calidad2
e5 = linkR e4 ny paris calidad1



-- LinkR
noesta = linkR e3 bsas miami calidad4
siEsta = linkR e3 paris ny calidad2

-- TunelR
tunel1 = tunelR e5 [bsas,ny,paris]

testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

test = [newP 2 2==p1, difP p5 p2== 4.0, distanceC bsas rio == difP p1 p2,
        capacityQ calidad3==5, delayQ calidad3 == 7.5, connectsL rio link01, 
        connectsL rio link03, linksL bsas rio link01, linksL rio bsas link01,
        linksL ny paris link04, capacityL link02==2, delayL link05==1.0, 
        testF(newT []), testF(tunelB), testF(noesta),testF(siEsta),
        testF(tunel1), connectsT ny bsas tunelA, connectsT bsas miami tunelA,
        connectsT miami bsas tunelA, usesT link04 tunelB, usesT link05 tunelC,
        delayT tunelB == 16.5, connectedR global miami bsas, connectedR global ny rio,
        linkedR global paris miami, linkedR global ny bsas, delayR global rio valencia == 14.5,
        availableCapacityForR global miami ny== 0, availableCapacityForR global bsas rio==3]
 
