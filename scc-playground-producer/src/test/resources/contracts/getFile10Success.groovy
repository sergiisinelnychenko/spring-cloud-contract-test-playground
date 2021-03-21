package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("Some successful scenario description goes here...")

	request {
		method(GET())
		url("/book/10")
	}
	response {
		status(OK())
		body("""
            {
              "bookContents": "Book with the ID 10"
            }
        """)
		headers {
			contentType("application/json")
		}
	}
}
