import Data.Array
import Control.Arrow (ArrowLoop(loop))

lijst :: Array Int Int
lijst = listArray (1, 5) [1,2,3,4,5]

main :: IO()

main = do
