; A guess is good enough when its value compared to the last guess is a very
; small fraction (i.e. when it changes very little guess-to-guess).
(defn good-enough? [guess prev-guess x]
  ;(println guess prev-guess)
  (< (/ (Math/abs (double (- guess prev-guess))) guess)
     1/1000))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

; approximate the square root of a number x via Newton's method
(defn sqrt-iter [guess prev-guess x]
  (if (good-enough? guess prev-guess x)
    guess
    (recur (improve guess x)
               guess
               x)))

(defn sqrt [x]
  (sqrt-iter 1.0 0 x)) ; use 1 instead of 1.0 for arbitrary precision instead of double; but slow

