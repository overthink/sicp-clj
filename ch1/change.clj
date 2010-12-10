; Making change.
;
; The number of ways to change amount a using n kinds of coins is:
;
; A) The number of ways to change amount a using all but the first kind of coin, plus
; B) The number of ways to change amount (a-d) using all n kinds of coins, where
;    d is the denomination of the first kind of coin.
;
; Had to think about this for a while.  On first read I had two issues:
; 1) Rules seemed arbitrary
; 2) Wasn't following the (a-d) part
; 
; The rules are setup to reduce the complexity of the problem: step A reduces
; the number of types of coins involved.  If you have such a reduction step,
; you will end up at a very simple degenerate case usualy, and recursion
; "magic" does all the work.  So that's a good strategy to keep in mind.
;
; The (a-d) part is simple after some thought:  If A is all the combinations of
; change not including a coin of denomination d, then all the combinations in B
; must include one or more coin of denomination d, so we can "factor out" that
; one coin by subtracting d from a.  If we don't do the subtraction, we'll
; double-count combinations from A.
;
(defn count-change [amount]
  (let [
        ;first-denomination {1 1, 2 5, 3 10, 4 25, 5 50, 6 100, 7 200}
        first-denomination {1 1, 2 5, 3 10, 4 25, 5 50}
        cc (fn cc [amount kinds-of-coins]
             (cond 
               (zero? amount) 1
               (or (neg? amount) (zero? kinds-of-coins)) 0
               :else (+ (cc amount (dec kinds-of-coins))
                        (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))]
        (cc amount 5)))

(count-change 100)
;(count-change 11)

