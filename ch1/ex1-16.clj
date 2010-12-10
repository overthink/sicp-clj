; exponentiation stuff
; b^n = (b^(n/2))^2 if n is even
; b^n = b*b^(n-1) if n is odd
(defn square [x] (* x x))

; recursive implementation of exponentiation
(defn fast-expt [b n]
  (cond 
    (zero? n) 1
    (even? n) (square (fast-expt b (/ n 2)))
    :else (* b (fast-expt b (dec n)))))

; Exercise: design a linear recursive (tail recursive) procedure that uses
; successive squaring and logarithmic number of steps.
;
; a - state variable/accumulator -- build up the answer in here
(defn expt-iter [b n a]
  (cond
    (zero? n) a
    (even? n) (recur (square b) (/ n 2) a) ; Note: (b^(n/2))^2 = (b^2)^(n/2)
    :else (recur b (dec n) (* b a))))

(defn expt [b n] (expt-iter b n 1))

