package contracts.task

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Test get task by task id wrong"
    description "Test get task by task id wrong"

    request {
        url "/api/task/4"

        headers {
            header(contentType(), applicationJson())
        }

        method GET()
    }

    response {
        status BAD_REQUEST()

        headers {
            header(contentType(), applicationJson())
        }

        body(
                """
                {
                    "data": null,
                    "errors": {
                        "errorCode": "400",
                        "errorDescription": "Task not found ! "
                    },
                    "time": "2021-01-09"
                }    
                           """
        )

    }

}

