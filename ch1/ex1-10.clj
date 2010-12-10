; Ackermann's function
;
(defn A [x y]
  (cond 
    (zero? y) 0
    (zero? x) (* 2 y)
    (= y 1) 2
    :else (A (dec x) (A x (dec y)))))

(defn f [n] (A 0 n))
; f(n) = 2n

(defn g [n] (A 1 n))
;(A 1 n)
;(A 0 (A 1 (dec y)))
;(* 2 (A 1 (dec y)))
;(* 2 (A 0 (A 1 (dec (dec y)))))
;(* 2 (* 2 (A 1 (dec (dec y)))))
;y keeps decrementing untill it is 1, then it terminates with value 2
; g(n) = 2^n

(defn h [n] (A 2 n))

;(h 0)
;(A 2 0)
;0
;
;(h 1)
;(A 2 1)
;2
;
;(h 2)
;(A 2 2)
;(A 1 (A 2 1))
;(A 1 2)
;(A 0 (A 2 1))
;(* 2 (A 2 1))
;(* 2 2)
;4
;
;(h 3)
;(A 2 3)
;(A 1 (A 2 2))
;(A 1 (A 1 (A 2 1)))
;(A 1 (A 1 2))
;(A 1 (A 0 (A 1 1)))
;(A 1 (* 2 (A 1 1)))
;(A 1 (* 2 2))
;(A 1 4)
;(g 4)
;2^4 == 16
;
;(h 4)
;(A 2 4)
;(A 1 (A 2 3))
;(g (A 2 3))
;(g 16)
;2^16 == 65536
;
; Had to look this up eventually, though I was so close!
;
;h(n) = 2^h(n-1) where  h(0) = 0, h(1) = 2.

