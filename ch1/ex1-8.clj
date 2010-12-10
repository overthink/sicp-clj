; A guess is good enough when its value compared to the last guess is a very
; small fraction (i.e. when it changes very little guess-to-guess).
(defn good-enough? [guess prev-guess x]
  ;(println guess prev-guess)
  (< (/ (Math/abs (double (- guess prev-guess))) guess)
     1/1000))

; If y is an approximation of the cubed root of x, then this fn yields a better
; approximation.
(defn improve [x y]
  (/ (+ (/ x (* y y)) (* 2 y))
     3))

; approximate the square root of a number x via Newton's method
(defn cubert-iter [guess prev-guess x]
  (if (good-enough? guess prev-guess x)
    guess
    (recur (improve x guess)
               guess
               x)))

(defn cubert [x]
  (cubert-iter 1.0 0 x)) ; use 1 instead of 1.0 for arbitrary precision instead of double; but slow

