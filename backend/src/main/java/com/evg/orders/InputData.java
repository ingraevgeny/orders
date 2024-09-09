package com.evg.orders;

public class InputData {
    public static String orders = """
            [
                 {
                   "clientId": "10",
                   "orderFulfillment": [
                       {
                         "status": "Initiated",
                         "medications": [
                             {
                               "name": "Advil",
                               "weight": "2",
                               "code": "A432"
                             },
                             {
                               "name": "Cocks",
                               "weight": "30",
                               "code": "C43892"
                             }
                         ]
                       }
                   ]
                 },
                 {
                    "clientId": "11",
                    "orderFulfillment": [
                      {
                          "status": "Initiated",
                          "medications": [
                              {
                                "name": "Piramidon",
                                "weight": "24",
                                "code": "PA432"
                              },
                              {
                                "name": "Cocks",
                                "weight": "300",
                                "code": "C43892"
                              }
                          ]
                      }
                    ]
                 },
                 {
                    "clientId": "13",
                    "orderFulfillment": [
                      {
                        "status": "Initiated",
                        "medications": [
                          {
                            "name": "Gerych",
                            "weight": "245",
                            "code": "G34432"
                          },
                          {
                            "name": "Grass",
                            "weight": "30",
                            "code": "G4H3892"
                          }
                        ]
                      }
                    ]
                },
                {
                   "clientId": "14",
                   "orderFulfillment": [
                     {
                       "status": "Initiated",
                       "medications": [
                             {
                               "name": "Advil",
                               "weight": "2",
                               "code": "A432"
                             },
                             {
                               "name": "Cocks",
                               "weight": "30",
                               "code": "C43892"
                             },
                             {
                               "name": "Dimedrol",
                               "weight": "30",
                               "code": "C4DH3892"
                             },
                             {
                               "name": "VitaminA",
                               "weight": "30",
                               "code": "VDC43892"
                             }
                       ]
                     },
                     {
                       "status": "Processing",
                       "droneId": "10",
                       "medications": [
                             {
                               "name": "Advil",
                               "weight": "2",
                               "code": "A432"
                             },
                             {
                               "name": "Cocks",
                               "weight": "30",
                               "code": "C43892"
                             },
                             {
                               "name": "Dimedrol",
                               "weight": "30",
                               "code": "C4DH3892"
                             },
                             {
                               "name": "VitaminA",
                               "weight": "30",
                               "code": "VDC43892"
                             }
                       ]
                     }
                   ]
               }
            ]
            """;
}



