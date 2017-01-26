(ns hanoi.core-test
  (:require [clojure.test :refer :all]
            [hanoi.core :refer :all]))

(t/deftest test-hanoi
  (t/is (= [[:a :b]]
           (sut/hanoi 1 :from :a :to :b :temp :c)))

  (t/is (= [[:a :c]
            [:a :b]
            [:c :b]]
           (sut/hanoi 2 :from :a :to :b :temp :c)))

  (t/is (= [[:a :b]
            [:a :c]
            [:b :c]
            [:a :b]
            [:c :a]
            [:c :b]
            [:a :b]]
           (sut/hanoi 3 :from :a :to :b :temp :c))))

(t/deftest test-do-instruction
  (t/is (= {:a [:--- :--]
            :b [:-]
            :c []}
           (sut/do-instruction {:a [:--- :-- :-]
                                :b []
                                :c []}
                               [:a :b]))))
