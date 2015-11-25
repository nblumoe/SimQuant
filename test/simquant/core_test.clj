(ns simquant.core-test
  (:require [clojure.test :refer :all]
            [simquant.core :refer :all]))

(deftest scale-test
  (testing "linear scale"
    (let [linear-scale (scale {:type :linear
                               :domain [0 1]
                               :range [10 20]})]
      (is (= (linear-scale 0) 10))
      (is (= (linear-scale 0.5) 15))
      (is (= (linear-scale 1) 20)))))
