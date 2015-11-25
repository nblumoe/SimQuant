(ns simquant.core-test
  (:require [clojure.test :refer :all]
            [simquant.core :refer :all]
            [clojure.test.check.generators :as generators]
            [clojure.test.check.properties :as properties]
            [clojure.test.check.clojure-test :refer [defspec]]))

(deftest scale-test-by-example
  (testing "linear scale"
    (let [linear-scale (scale :linear [0 1] [10 20])]
      (is (= (linear-scale 0) 10))
      (is (= (linear-scale 0.5) 15.0))
      (is (= (linear-scale 1) 20)))
    (let [linear-scale (scale :linear [10 30] [100 200])]
      (is (= (linear-scale 10) 100))
      (is (= (linear-scale 20) 150))
      (is (= (linear-scale 30) 200)))))

(def distinct-doubles-gen
  (generators/not-empty (generators/vector-distinct generators/int {:num-elements 2})))

(defspec linear-scale-range-properties 3000
  (properties/for-all [domain distinct-doubles-gen
                       range distinct-doubles-gen
                       value generators/int]
                      (let [linear-scale (scale :linear domain range)
                            domain-length (- (last domain) (first domain))
                            range-length (- (last range) (first range))
                            m (/ range-length domain-length)
                            b (first range)
                            offset (first domain)]
                        (is (= (linear-scale value)
                               (+ (* m (- value offset)) b))))))
