-- https://www.haskell.org/get-started/#:~:text=Visual%20Studio%20Code%20(VSCode)%20is,HLS%20docs%20for%20editor%20configuration.

main = do
    putStrLn "hi"
    putStrLn ("kijk dit zijn onevennummers: " ++ show (filter odd [1..10]))