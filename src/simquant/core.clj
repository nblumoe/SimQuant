(ns simquant.core
  (:require [simquant.fixtures :as fixtures]))

(defn interval-length [[start end]]
  (- end start))

(defmulti scale :type)

(defmethod scale :linear
  [{:keys [domain range]}]
  (let [domain-length (interval-length domain)
        range-length (interval-length range)]
    (fn [x] (+ (first range)
               (* (/ x domain-length) range-length)))))

(def app-state
  (atom fixtures/user-data))

(defn user-record [username record-name]
  (-> @app-state
      (get username)
      :records
      (get record-name)))
