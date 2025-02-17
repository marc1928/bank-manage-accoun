package materialstech.com.gatewayservice.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> customersServiceRoute() {
        return GatewayRouterFunctions.route("customer-service")
                .route(RequestPredicates.path("/api/customers/**"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> accountServiceRoute() {
        return GatewayRouterFunctions.route("account-service")
                .route(RequestPredicates.path("/api/accounts/**"), HandlerFunctions.http("http://localhost:8082"))
                .build();
    }
}
