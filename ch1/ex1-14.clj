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

; Draw the tree of recursion for (count-change 11) -> (cc 11 5)
; Drawing this in ASCII is a huge pain.  I'll draw the first bit.  It's easy on paper.
;
;                              (cc 11 5)
;                               /     \
;                         (cc 11 4) (cc -39 5)
;                          /     \           |
;                   (cc 11 3)  (cc -14 4)    0
;                  /     \         |
;           (cc 11 2)  (cc 1 3)    0
;             ...        ...
;
; It's fairly huge.
;
; I'm not really sure about the time and space analysis.
;
; It seems to be linear in space since the maximum depth of the tree is for the
; combination of change where it's all pennies.  i.e. for $1 there is a 100
; node depth when coming up with the 0.01*100 combination.
;
; Time analysis: beyond me :)  The Interwebs are claiming O(n^m) where m is the
; number of types of coin.  Seems reasonable.
; 

