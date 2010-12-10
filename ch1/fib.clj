(defn terrible-fib [n]
  "Elegant but very slow O(2^n) in time fibonacci implementation."
  (cond 
    (= n 0) 0
    (= n 1) 1
    :else (+ (terrible-fib (- n 1)) (terrible-fib (- n 2)))))

(defn better-fib [n]
  "O(n) Fibonacci implementation."
  (let [fib-iter (fn [a b count]
                   (if (zero? count)
                     b
                     (recur (+ a b) a (dec count))))]
        (fib-iter 1 0 n)))

