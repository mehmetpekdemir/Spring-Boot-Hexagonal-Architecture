package contracts.task

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Test get task by task id correct"
    description "Test get task by task id correct"

    request {
        url "/api/task/1"

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
                        "description": "Task Description 1"
                    },
                    "errors": null,
                    "time": "2021-01-09"
                }           
                           """
        )

    }

}

