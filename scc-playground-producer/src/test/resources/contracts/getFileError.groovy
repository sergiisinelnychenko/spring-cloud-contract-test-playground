package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Some error scenario description goes here...")

    request {
        method(GET())
        url("/book/-222")
    }
    response {
        status(BAD_REQUEST())
        body("""
            {
              "message": "Incorrect book id"
            }
        """)
        headers {
            contentType('application/json')
        }
    }
}
