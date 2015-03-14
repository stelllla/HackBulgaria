factors :: Int -> [Int] 
factors a = [x | x<-[1..a] , (rem a x) == 0]

isPrime :: Int -> Bool
isPrime a = (a + 1) == (foldl (+) 0 (factors a))

primes :: Int -> Int ->[Int]
primes a b = [x | x<-[a..b], (isPrime x)]

primesInAnInterval :: Int -> Int -> [Int]
primesInAnInterval a b 
	|a > b = error "invalid input"
	|otherwise = primes a b
