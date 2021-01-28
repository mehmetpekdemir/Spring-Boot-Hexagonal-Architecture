package contracts.taskversion

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "Test get task version by version number correct"
    description "Test get task version by version number correct"

    request {
        url "/api/task-version/1/version/1"

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
                            "versionNumber": 1,
                            "subject": "Subject 1",
                            "description": "Description 1"
                    },
                    "errors": null,
                    "time": "2021-01-29"
                }        
                           """
        )

    }

}

