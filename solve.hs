import Data.List

solve :: [String] -> [String]
solve wordList = map bigger' wordList
    where bigger' xs = if (bigger xs) == xs then "no answer" else (bigger xs)

bigger :: String -> String
bigger []  = []
bigger [x] = [x]
bigger str
    | not (any (> second) rest) = picked : (sort $ delete picked str)
    | otherwise = [first, newSecond] ++ bigger (second: (delete newSecond rest))
        where picked = case filtered of
                            [] -> first
                            _  -> minimum filtered
              first = head str
              second = head $ tail str
              rest  = drop 2 str
              newSecond = minimum $ filter (> second) rest
              filtered = filter ( > first) str

merge :: [Integer] -> [Integer] -> [Integer]
merge [] [] = []
merge as []     = as
merge []     bs  = bs
merge (a:as) (b:bs)   
  | a < b   = a : (merge as (b:bs))
  | a == b  = a : (merge as bs)
  | b > a   = b : (merge (a:as) bs)

xs :: [Integer]
xs = 1 : merge (map(2*)xs) (map(5*)xs)