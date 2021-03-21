package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("Some successful scenario description goes here...")

	request {
		method(GET())
		url("/book/123")
	}
	response {
		status(OK())
		body("""
            {
              "bookContents": "Book with the ID 123"
            }
        """)
		headers {
			contentType("application/json")
		}
	}
}
