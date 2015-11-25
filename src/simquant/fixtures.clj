(ns simquant.fixtures)

(def user-data  {"Nils" {:username "Nils"
                         :avatar "https://avatars1.githubusercontent.com/u/995628?v=3&s=400"
                         :records {"Weight" {:title "Weight"
                                             :dimensions [:time :weight]
                                             :data [[0 92]
                                                    [1 90]
                                                    [3 89]
                                                    [10 75]
                                                    [15 83]
                                                    [80 73]
                                                    [90 80]
                                                    ]}
                                   "Sports" {:title "Sports"
                                             :dimensions [:time :duration :distance :kcals :type]
                                             :data [[0 10 3 123 :run]
                                                    [1 21 12 323 :indoor-cycling]]}}}

                 "Magda "{:username "Magda"
                          :avatar "https://0.academia-photos.com/2823676/923282/2720730/s200_magdalena.banaszak.jpg"
                          :records [{:name "Weight"
                                     :dimensions [:time :weight]
                                     :data [[0 54]
                                            [1 53]]}
                                    {:name "Sports"
                                     :dimensions [:time :duration :distance :kcals :type]
                                     :data [[0 5 3 123 :run]
                                            [1 14 12 323 :indoor-cycling]]}]}})
