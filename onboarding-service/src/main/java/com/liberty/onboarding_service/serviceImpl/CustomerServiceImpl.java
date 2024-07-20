package com.liberty.onboarding_service.serviceImpl;

import com.liberty.onboarding_service.dto.ApiResponse;
import com.liberty.onboarding_service.dto.BvnOrNInValidationRequest;
import com.liberty.onboarding_service.dto.BvnOrNInValidationResponse;
import com.liberty.onboarding_service.model.Customer;
import com.liberty.onboarding_service.repository.CustomerRepository;
import com.liberty.onboarding_service.repository.NinBvNRepository;
import com.liberty.onboarding_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final NinBvNRepository ninBvNRepository;
    @Override
    public Customer onboardCustomer(Customer customer) {
        // Validate BVN and NIN here
        return customerRepository.save(customer);
    }

    /**
     * Simulating BvN or NIN verification assuming they are stored on a remote
     * server or this could be achieved through a third party integration
    */
    @Override
    public ApiResponse<BvnOrNInValidationResponse> validateCustomerBvnOrNIN(BvnOrNInValidationRequest bvnOrNInValidationRequest) {
        //Validating BVN Or NIN provided by the customer and giving priority of 1 to customer's BVN
        String bvnOrNin = (bvnOrNInValidationRequest.getBvn() != null && !bvnOrNInValidationRequest.getNin().isEmpty()) ? "bvn" : "nin";
        Optional<Customer> customerDetails;

        switch (bvnOrNin) {
            case "bvn" -> customerDetails = ninBvNRepository.findByBvn(bvnOrNInValidationRequest.getBvn());
            case "nin" -> customerDetails = ninBvNRepository.findByNin(bvnOrNInValidationRequest.getNin());
            default -> {
                return new ApiResponse<>(false, null, "Invalid input");
            }
        }

        if (customerDetails.isPresent()) {
            Customer customer = customerDetails.get();
            return new ApiResponse<>(true, new BvnOrNInValidationResponse(customer.getFirstName(),customer.getLastName(),customer.getMiddleName()), "Customer validated successfully");
        } else {
            return new ApiResponse<>(false, null, "No data found for this customer");
        }
    }

    @Override
    public ApiResponse<Customer> getDashBoardDetails(String customerId) {
        return new ApiResponse<>(true,customerRepository.findByCustomerId(customerId).
                orElseThrow(),"success");
    }


}
