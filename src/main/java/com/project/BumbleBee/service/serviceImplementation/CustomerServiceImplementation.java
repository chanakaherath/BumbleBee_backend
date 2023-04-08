package com.project.BumbleBee.service.serviceImplementation;

import com.project.BumbleBee.dto.request.CustomerSaveRequest;
import com.project.BumbleBee.dto.request.UserSaveRequest;
import com.project.BumbleBee.dto.response.CustomerResponse;
import com.project.BumbleBee.dto.response.UserResponse;
import com.project.BumbleBee.entity.Customer;
import com.project.BumbleBee.entity.User;
import com.project.BumbleBee.repository.CustomerRepository;
import com.project.BumbleBee.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponse save(CustomerSaveRequest saveRequest) {

        try {

            Customer customer = new Customer();

            customer.setFirstName(saveRequest.getFirstName());
            customer.setLastName(saveRequest.getLastName());
            customer.setBirthday(saveRequest.getBirthday());
            customer.setUser(convertNotificationSaveRequest(saveRequest.getUser()));

            customer.getUser().setCustomer(customer);

            Customer saveResponse = customerRepository.save(customer);

            return getResponse(saveResponse);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }

    @Override
    public List<CustomerResponse> getAll() {

        try {

            return customerRepository.findAll().stream().map(CustomerServiceImplementation::getResponse).collect(Collectors.toList());

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }

    private static CustomerResponse getResponse(Customer customer) {

        CustomerResponse response = new CustomerResponse();

        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setBirthday(customer.getBirthday());
        response.setUser(getUserResponse(customer.getUser()));

        return response;

    }

    public static User convertNotificationSaveRequest(UserSaveRequest userSaveRequest) {

        User user = new User();

        user.setEmail(userSaveRequest.getEmail());
        user.setUsername(userSaveRequest.getUsername());
        user.setPassword(userSaveRequest.getPassword());
        user.setRole("Customer");

        return user;

    }

    private static UserResponse getUserResponse(User user) {

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setUsername(user.getUsername());
        userResponse.setRole(user.getRole());

        return userResponse;

    }

    private static UserResponse getUserResponseList(User user) {

        UserResponse userResponse = new UserResponse();

//        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setUsername(user.getUsername());
        userResponse.setRole(user.getRole());

        return userResponse;

    }
}
