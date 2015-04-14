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
