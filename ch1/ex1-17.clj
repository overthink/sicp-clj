; Implement multiplication using only addition, double, and halve.
;
; a * b = 0 if b = 0
; a * b = a + a * (b - 1)
;
; a*b = 0 if b = 0
; a*b = dbl(a * halve(b)) if b even
; a*b = b + (a * b-1)

(defn dbl [x] (* x 2))
(defn halve [x] (/ x 2))

(defn mult [a b]
  (cond
    (zero? b) 0
    (even? b) (dbl (mult a (halve b)))
    :else (+ a (mult a (dec b))))) ; e.g. 6*4 == 6+6+6+6 == dbl(6*halve(4)) == 2*6*2

