(ns simquant.core
  (:require [simquant.fixtures :as fixtures]))

(defmulti scale (fn [type _ _] type))

(defn linear-equation [m b]
  (fn [x] (+ (* m x) b)))

(defmethod scale :linear
  [_ [domain-start domain-end] [range-start range-end]]
  (let [domain-length (- domain-end domain-start)
        range-length (- range-end range-start)]
    (linear-equation (/ range-length domain-length) range-start)))

(def app-state (atom fixtures/user-data))

(defn user-record [username record-name]
  (-> @app-state
      (get username)
      :records
      (get record-name)))
