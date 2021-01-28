package contracts.taskversion

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Test get task version by version number wrong"
    description "Test get task version by version number wrong"

    request {
        url "/api/task-version/1/version/2"

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
                          "errorDescription": "Version number not found !"
                    },
                    "time": "2021-01-29"
                }    
                           """
        )

    }

}

