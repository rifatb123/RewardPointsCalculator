# RewardPointsCalculator
Calculating reward points based on months and total months
1. Project Structure
•	Controller: RESTful endpoint to handle requests.
•	Service: Business logic to calculate reward points.
•	Model: Define the Transaction and Customer entities.
•	Exception Handling: For any unexpected errors.
•	Testing: Unit tests for the service.
RequestBody in postman:
1)for monthly reward
GET:  http://localhost:8081/api/rewards/customer/rajee/month/january
[
  {
    "name": "rajee",
    "transactions": [
      {
        "amount": 120,
        "month": "january"
      },
      {
        "amount": 75,
        "month": "january"
      }
    ]
  },
  {
    "name": "john",
    "transactions": [
      {
        "amount": 200,
        "month": "january"
      },
      {
        "amount": 50,
        "month": "february"
      }
    ]
  }
]

2)For total:
GET:  http://localhost:8081/api/rewards/customer/john/total

[
  {
    "name": "rajee",
    "transactions": [
      {
        "amount": 120,
        "month": "january"
      },
      {
        "amount": 75,
        "month": "january"
      },
      {
        "amount": 85,
        "month": "january"
      }
    ]
  },
  {
    "name": "john",
    "transactions": [
      {
        "amount": 200,
        "month": "january"
      },
      {
        "amount": 50,
        "month": "february"
      },
      {
        "amount": 95,
        "month": "january"
      }
    ]
  }
]

