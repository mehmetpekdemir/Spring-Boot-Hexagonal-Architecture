package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Test get task by task id correct"
    description "Test get task by task id correct"

    request {
        url "/api/v1/task/1"

        headers {
            header(contentType(), applicationJson())
        }

        method GET()
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
                        "id": 1,
                        "name": "Task Name 1",
                        "subject": "Test Subject 1",
                        "description": "Test Description 1"
                    },
                    "errors": null,
                    "time": "2021-01-30"
                }         
                           """
        )

    }

}

