(defn plus1 [a b] (if (zero? a) b (inc (plus1 (dec a) b))))
; Expansion of (plus1 4 5)
;(plus1 4 5)
;(inc (plus1 3 5))
;(inc (inc (plus1 2 5)))
;(inc (inc (inc (plus1 1 5))))
;(inc (inc (inc (inc (plus1 0 5)))))
;(inc (inc (inc (inc 5))))
;(inc (inc (inc 6)))
;(inc (inc 7))
;(inc 8)
;9

; plus1 is a recursive process.


(defn plus2 [a b] (if (zero? a) b (recur (dec a) (inc b))))
; plus2 is an interative process defined by a recursive procedure.  In Clojure,
; a shortcut to knowing this is that you can use recur (i.e. the procedure is
; tail-recursive).

; Expansion of (plus2 4 5)
;(plus2 4 5)
;(plus2 3 6)
;(plus2 2 7)
;(plus2 1 8)
;(plus2 0 9)
;9

