; Implement linearly recursive multiplication using only addition, double, and halve.

(defn dbl [x] (* x 2))
(defn halve [x] (/ x 2))

(defn mult-iter [a b acc]
  (cond
    (zero? b) acc
    (even? b) (recur (dbl a) (halve b) acc) ; note a*b = 2a*b/2
    :else (recur a (dec b) (+ a acc))))

; Note to self: note how the 'even' case passes some data to the 'odd' case via
; the argument a.  Also note that only the one case, 'odd' actually changes the
; accumulated value.

(defn mult [a b]
  (mult-iter a b 0))

