Feature: add to cart functionality

@addToCart
Scenario: add any two products to cart
	Given user is in user home page
	When user selects one product and add to cart
	And user selects second product and add to cart
	Then products must added to cart and diplays order total