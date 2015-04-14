(ns fourclosure.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; Elementary problems from http://www.4clojure.com/

; http://www.4clojure.com/problem/1 Nothing but the Truth
; (= __ true)
(= true true)

; http://www.4clojure.com/problem/2 Simple Math
; (= (- 10 (* 2 3)) __)
(= (- 10 (* 2 3)) 4)

; http://www.4clojure.com/problem/3 Into to Strings
; (= __ (.toUpperCase "hello world"))
(= "HELLO WORLD" (.toUpperCase "hello world"))

; http://www.4clojure.com/problem/4 Into to Lists
; (= (list __) '(:a :b :c))
(= (list :a :b :c) '(:a :b :c))

; http://www.4clojure.com/problem/5 Lists: conj
; (= __ (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(2 3 4) 1))
; (= __ (conj '(3 4) 2 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

; http://www.4clojure.com/problem/6 Into to Vectors
; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

; http://www.4clojure.com/problem/7 Vectors: conj
; (= __ (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2 3] 4))
; (= __ (conj [1 2] 3 4))
(= [1 2 3 4] (conj [1 2] 3 4))

; http://www.4clojure.com/problem/8 Intro to Sets
; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))
(= (set [:a :b :c :d]) (clojure.set/union #{:a :b :c} #{:b :c :d}))

; http://www.4clojure.com/problem/9 Sets: conj
; (= #{1 2 3 4} (conj #{1 4 3} __))
(= #{1 2 3 4} (conj #{1 4 3} 2))

; http://www.4clojure.com/problem/10 Into to Maps
; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
; (= __ (:b {:a 10, :b 20, :c 30}))
(= 20 (:b {:a 10, :b 20, :c 30}))

; http://www.4clojure.com/problem/11 Maps: conj
; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

; http://www.4clojure.com/problem/12 Intro to Sequences
; (= __ (first '(3 2 1)))
(= 3 (first '(3 2 1)))
; (= __ (second [2 3 4]))
(= 3 (second [2 3 4]))
; (= __ (last (list 1 2 3)))
(= 3 (last (list 1 2 3)))

; http://www.4clojure.com/problem/13 Sequences: rest
; (= __ (rest [10 20 30 40]))
(= [20 30 40] (rest [10 20 30 40]))

; http://www.4clojure.com/problem/14 Intro to Functions
; (= __ ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn add-five [x] (+ x 5)) 3))
; (= __ ((fn [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
; (= __ (#(+ % 5) 3))
(= 8 (#(+ % 5) 3))
; (= __ ((partial + 5) 3))
(= 8 ((partial + 5) 3))

; http://www.4clojure.com/problem/15 Double Down
; (= (__ 2) 4)
(defn double-down [x] "multiply x by 2" (* 2 x))
(= (double-down 2) 4)
; (= (__ 3) 6)
(= (double-down 3) 6)
; (= (__ 11) 22)
(= (double-down 11) 22)
; (= (__ 7) 14)
(= (double-down 7) 14)
