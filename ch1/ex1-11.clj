;
; f(n) = n if n < 3
;      = f(n-1) + 2f(n-2) + 3f(n-3) if n >= 3
;
(defn f [n]
  "Recursive procedure for implementing f."
  (cond 
    (< n 3) n
    :else (+ (f (- n 1)) (* 2 (f (- n 2))) (* 3 (f (- n 3))))))

; f(5) =
; f(4) + 2f(3) + 3f(2)
; [f(3) + 2f(2) + 3f(1)] + 2[f(2) + 2f(1) + 3f(0)] + 3(2)
; [[f(2) + 2f(1) + 3f(0)] + 2(2) + 3(1)] + 2(2 + 2(1) + 3(0)) + 6
; [2 + 2(1) + 3(0)] + 4 + 3 + 2(4) + 6
; 4 + 4 + 3 + 8 + 6
; 25
;


; Cheated... http://community.schemewiki.org/?sicp-ex-1.11  But ultimately
; here's my understanding:
;
; Need to pass the values that would be tree recursive calls into the
; procedure.  In this case f(0), f(1), f(2) are all trivial/degenerate cases.
; Consider then n=3:
;
; f(0) = 0
; f(1) = 1
; f(2) = 2
; f(3) = f(2) + 2f(1) + 3f(0) = 2 + 1 + 0 = 3
;
; Another way is that the tail-recursive solution works "up" from n=0, whereas
; the tree-recursive solution works "down" from n.
;
; So, let:
; x = f(n-1)
; y = f(n-2)
; z = f(n-3)
;
(defn f2 [n]
  "Iterative procedure for implementing f."
  (let [f-iter (fn [x y z n]
                 (if (< n 3)
                   x
                   (recur (+ x (* 2 y) (* 3 z)) x y (dec n))))]
  (if (< n 3)
    n
    (f-iter 2 1 0 n))))
                 


