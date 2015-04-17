(ns fourclosure.core)

;; Problems from http://www.4clojure.com/ where I am BannerAd.

; http://www.4clojure.com/problem/1 Nothing but the Truth
(= true true)

; http://www.4clojure.com/problem/2 Simple Math
(= (- 10 (* 2 3)) 4)

; http://www.4clojure.com/problem/3 Into to Strings
(= "HELLO WORLD" (.toUpperCase "hello world"))

; http://www.4clojure.com/problem/4 Into to Lists
(= (list :a :b :c) '(:a :b :c))

; http://www.4clojure.com/problem/5 Lists: conj
(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))

; http://www.4clojure.com/problem/6 Into to Vectors
(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

; http://www.4clojure.com/problem/7 Vectors: conj
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

; http://www.4clojure.com/problem/8 Intro to Sets
(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= (set [:a :b :c :d]) (clojure.set/union #{:a :b :c} #{:b :c :d}))

; http://www.4clojure.com/problem/9 Sets: conj
(= #{1 2 3 4} (conj #{1 4 3} 2))

; http://www.4clojure.com/problem/10 Into to Maps
(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))

; http://www.4clojure.com/problem/11 Maps: conj
(= {:a 1, :b 2, :c 3} (conj {:a 1} {:b 2} [:c 3]))

; http://www.4clojure.com/problem/12 Intro to Sequences
(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))

; http://www.4clojure.com/problem/13 Sequences: rest
(= [20 30 40] (rest [10 20 30 40]))

; http://www.4clojure.com/problem/14 Intro to Functions
(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5) 3))
(= 8 ((partial + 5) 3))

; http://www.4clojure.com/problem/15 Double Down
(defn double-down [x] "multiply x by 2" (* 2 x))
(= (double-down 2) 4)
(= (double-down 3) 6)
(= (double-down 11) 22)
(= (double-down 7) 14)

; http://www.4clojure.com/problem/16 Hello World
(defn hello-world [greetee]
  "return personalized greeting"
  (str "Hello, " greetee "!"))
(= (hello-world "Dave") "Hello, Dave!")
(= (hello-world "Jenn") "Hello, Jenn!")
(= (hello-world "Rhea") "Hello, Rhea!")

; http://www.4clojure.com/problem/17 Sequences: map
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

; http://www.4clojure.com/problem/18 Sequences: filter
(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

; http://www.4clojure.com/problem/19 Last Element
(defn last-element [coll] (reduce (fn [x y] y) coll))
(= (last-element [1 2 3 4 5]) 5)
(= (last-element '(5 4 3)) 3)
(= (last-element ["b" "c" "d"]) "d")

; http://www.4clojure.com/problem/20 Penultimate Element
(defn penultimate-element [coll] (nth coll (- (count coll) 2)))
(= (penultimate-element (list 1 2 3 4 5)) 4)
(= (penultimate-element ["a" "b" "c"]) "b")
(= (penultimate-element [[1 2] [3 4]]) [1 2])

; http://www.4clojure.com/problem/21 Nth Element
(defn nth-element [coll ix]
  (loop [i 0 loop-coll coll]
    (if (= i ix)
      (first loop-coll)
      (recur (inc i) (rest loop-coll)))))
(= (nth-element '(4 5 6 7) 2) 6)
(= (nth-element [:a :b :c] 0) :a)
(= (nth-element [1 2 3 4] 1) 2)
(= (nth-element '([1 2] [3 4] [5 6]) 2) [5 6])

; http://www.4clojure.com/problem/22 Count a Sequence
(defn count-a-sequence [s] (reduce (fn [x y] (inc x)) 0 s))
(= (count-a-sequence '(1 2 3 3 1)) 5)
(= (count-a-sequence "Hello World") 11)
(= (count-a-sequence [[1 2] [3 4] [5 6]]) 3)
(= (count-a-sequence '(13)) 1)
(= (count-a-sequence '(:a :b :c)) 3)

; http://www.4clojure.com/problem/23 Reverse a Sequence
(defn reverse-a-sequence [coll]
  (loop [[r & more :as all] (seq coll) acc '()]
    (if all
      (recur more (cons r acc))
      acc)))
(= (reverse-a-sequence [1 2 3 4 5]) [5 4 3 2 1])
(= (reverse-a-sequence (sorted-set 5 7 2 7)) '(7 5 2))
(= (reverse-a-sequence [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])

; http://www.4clojure.com/problem/24 Sum It All Up
(defn sum-it-all-up [coll] (reduce + coll))
(= (sum-it-all-up [1 2 3]) 6)
(= (sum-it-all-up (list 0 -2 5 5)) 8)
(= (sum-it-all-up #{4 2 1}) 7)
(= (sum-it-all-up '(0 0 -1)) -1)
(= (sum-it-all-up '(1 10 3)) 14)

; http://www.4clojure.com/problem/25 Find the odd numbers
(defn find-the-odd-numbers [coll] (filter odd? coll))
(= (find-the-odd-numbers #{1 2 3 4 5}) '(1 3 5))
(= (find-the-odd-numbers [4 2 1 6]) '(1))
(= (find-the-odd-numbers [2 2 4 6]) '())
(= (find-the-odd-numbers [1 1 1 3]) '(1 1 1 3))

; http://www.4clojure.com/problem/28 Flatten a Sequence
(defn bob-flatten [coll]
  (let [[head & tail] coll]
    (cond
      (empty? coll) '()
      (coll? head) (concat (bob-flatten head) (bob-flatten tail))
      :else (cons head (bob-flatten tail)))))
(= (bob-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (bob-flatten ["a" ["b"] "c"]) '("a" "b" "c"))
(= (bob-flatten '((((:a))))) '(:a))
; I really struggled with this one;n interesting solution to "Flatten a Sequence"
; I am puzzled as to how a reducer fn can have 2 arguments
; lifted from https://github.com/ptrv/4clojure-solutions/blob/master/solutions.clj
(fn [coll]
  (seq
    (reduce
      (fn my-flatten [v e]
        (if (coll? e)
          (reduce my-flatten v e)
          (conj v e)))
      []
      coll)))

; http://www.4clojure.com/problem/29 Get the Caps
(defn get-the-caps [s] (apply str (re-seq #"[A-Z]" (str s))))
(= (get-the-caps "HeLlO, WoRlD!") "HLOWRD")
(= (get-the-caps "HeLlO, WoRlD!") "HLOWRD")
(= (get-the-caps "$#A(*&987Zf") "AZ")

; http://www.4clojure.com/problem/26 Fibonacci Sequence
(defn bob-fib-seq [n]
  (map (fn bob-fib [n]
         (cond
           (= n 0) 0
           (= n 1) 1
           :else (+ (bob-fib (- n 1)) (bob-fib (- n 2)))))
       (range 1 (+ n 1))))
(= (bob-fib-seq 3) '(1 1 2))
(= (bob-fib-seq 6) '(1 1 2 3 5 8))
(= (bob-fib-seq 8) '(1 1 2 3 5 8 13 21))

; http://www.4clojure.com/problem/27 Palindrome Detector
(defn plaindrome? [coll] (= (seq coll) (reverse coll)))
(false? (plaindrome? '(1 2 3 4 5)))
(true? (plaindrome? "racecar"))
(true? (plaindrome? [:foo :bar :foo]))
(true? (plaindrome? '(1 1 3 3 1 1)))
(false? (plaindrome? '(:a :b :c)))

; http://www.4clojure.com/problem/35 Local bindings
(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3, y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))

; http://www.4clojure.com/problem/36 Let it Be
(= 10 (let [x 7 y 3 z 1] (+ x y)))
(= 4 (let [x 7 y 3 z 1] (+ y z)))
(= 1 (let [x 7 y 3 z 1] z))

; http://www.4clojure.com/problem/37 Regular Expressions
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

; http://www.4clojure.com/problem/64 Intro to Reduce
(= 15 (reduce + [1 2 3 4 5]))
(=  0 (reduce + []))
(=  6 (reduce + 1 [2 3]))

; http://www.4clojure.com/problem/57 Simple Recursion
(= '(5 4 3 2 1) ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))

; http://www.4clojure.com/problem/134 A nil key
(defn a-nil-key? [k m]
  (if (contains? m k)
    (nil? (get m k))
    false))
(true?  (a-nil-key? :a {:a nil :b 2}))
(false? (a-nil-key? :b {:a nil :b 2}))
(false? (a-nil-key? :c {:a nil :b 2}))

; http://www.4clojure.com/problem/38 Maximum value
(defn max-value [& args] (reduce (fn [x y] (if (> x y) x y) ) args ))
(= (max-value 1 8 3 4) 8)
(= (max-value 30 20) 30)
(= (max-value 45 67 11) 67)

; http://www.4clojure.com/problem/39 Interleave two Seqs
(defn interleave-two-seqs [a b]
  (loop [r [] a (seq a) b (seq b)]
    (if (or (empty? a) (empty? b))
      r
      (recur (conj r (first a) (first b)) (rest a) (rest b)))))
(= (interleave-two-seqs [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (interleave-two-seqs [1 2] [3 4 5 6]) '(1 3 2 4))
(= (interleave-two-seqs [1 2 3 4] [5]) [1 5])
(= (interleave-two-seqs [30 20] [25 15]) [30 25 20 15])

