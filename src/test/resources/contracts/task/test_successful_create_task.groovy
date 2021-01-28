package contracts.task

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Test successful create task"
    description "Test successful create task"

    request {
        url "/api/task"

        headers {
            header(contentType(), applicationJson())
        }

        method POST()

        body(
                """
            {
                "name":"Test Task Name",
                "versionNumber":1,
                "subject":"Test subject",
                "description":"Test description"
            }
                """
        )

    }

    response {
        status OK()

        headers {
            header(contentType(), applicationJson())
        }

        body(
                """
                {
                    "data": {
                        "id": 2,
                        "name": "Test Task Name"
                    },
                    "errors": null,
                    "time": "2021-01-29"
                }     
                           """
        )

    }

}

