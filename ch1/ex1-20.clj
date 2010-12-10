; How many remainder ops are performed in the normal-order evaluation of (gcd
; 206 40) vs. the appicative order evaluation?
;
; Normal order: fully expand, then reduce
; Applicative order: apply first
;

(defn remainder [a b] 
  (mod a b))

(defn gcd [a b]
  "Euclid's algorithm"
  (if (zero? b)
    a
    (recur b (remainder a b))))

; Cheated: http://community.schemewiki.org/?sicp-ex-1.20
; - wasn't sure how to write it out without going insane
; 
; (gcd 206 40) in normal order:
;
; (if (zero? 40) ...)
; (gcd 40 (remainder 206 40))
; ;     a          b
; (if (zero? (remainder 206 40)) ...)
; (if (zero? 6) ...)
; (gcd (remainder 206 40) (remainder 40 (remainder 206 40)))
;             a                             b
; (if (zero? (remainder 40 (remainder 206 40))))
; (if (zero? 4) ...)
; (gcd (remainder 40 (remainder 206 40)) (remainder (remainder 206 40) (remainder 40 (remainder 206 40))))
;                     a                                                     b
; (if (zero? (remainder 6 (remainder 40 6))))
; (if (zero? (remainder 6 4)))
; (if (zero? 2) ...)
; (gcd (remainder (remainder 206 40) (remainder 40 (remainder 206 40))) (remainder (remainder 40 (remainder 206 40)) (remainder (remainder 206 40) (remainder 40 (remainder 206 40)))))
;
; (if (zero? (remainder (remainder 40 (remainder 206 40)) (remainder (remainder 206 40) (remainder 40 (remainder 206 40))))) ...)
; (if (zero? (remainder (remainder 40 6) (remainder 6 (remainder 40 6)))) ...)
; (if (zero? (remainder 4 (remainder 6 4))))
; (if (zero? (remainder 4 2)) ... )
; ... => (remainder (remainder 206 40) (remainder 40 (remainder 206 40)))
;        (remainder 6 (remainder 40 6))
;        (remainder 6 4)
;        2
;
; Retarded.
;
;
;
; (gcd 206 40) in applicative (i.e. sane) order
;
; (gcd 40 (reaminder 206 40))
; (gcd 40 6)
; (gcd 6 (reaminder 40 6))
; (gcd 6 4)
; (gcd 4 (remainder 6 4))
; (gcd 4 2)
; (gcd 2 (remainder 4 2))
; (gcd 2 0)
; 2
;
; remainder called 4 times.

