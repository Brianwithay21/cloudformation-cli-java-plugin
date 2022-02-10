package {{ package_name }};

import java.util.Map;
import java.util.HashMap;
import software.amazon.cloudformation.proxy.Logger;
import software.amazon.cloudformation.proxy.AmazonWebServicesClientProxy;
import software.amazon.cloudformation.proxy.hook.HookStatus;
import software.amazon.cloudformation.proxy.hook.HookProgressEvent;
import software.amazon.cloudformation.proxy.hook.HookHandlerRequest;
import software.amazon.cloudformation.proxy.hook.HookContext;
import software.amazon.cloudformation.proxy.hook.targetmodel.HookTargetModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class {{ operation }}HookHandlerTest {

    @Mock
    private AmazonWebServicesClientProxy proxy;

    @Mock
    private Logger logger;

    @BeforeEach
    public void setup() {
        proxy = mock(AmazonWebServicesClientProxy.class);
        logger = mock(Logger.class);
    }

    @Test
    public void handleRequest_SimpleSuccess_OtherExampleResource() {
        final {{ operation }}HookHandler handler = new {{ operation }}HookHandler();

        final TypeConfigurationModel typeConfiguration = mock(TypeConfigurationModel.class);
        when(typeConfiguration.getEncryptionAlgorithm()).thenReturn("AES256");

        final Map<String, Object> targetModel = new HashMap<>();
        final Map<String, Object> resourceProperties = new HashMap<>();
        resourceProperties.put("OtherEncryptionAlgorithm", "AES256");
        targetModel.put("ResourceProperties", resourceProperties);

        final HookHandlerRequest request = HookHandlerRequest.builder()
            .hookContext(HookContext.builder().targetName("Other::Example::Resource").targetModel(HookTargetModel.of(targetModel)).build())
            .build();

        final HookProgressEvent<CallbackContext> response = handler.handleRequest(proxy, request, null, logger, typeConfiguration);

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HookStatus.SUCCESS);
        assertThat(response.getCallbackContext()).isNull();
        assertThat(response.getCallbackDelaySeconds()).isEqualTo(0);
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getErrorCode()).isNull();
    }

    @Test
    public void handleRequest_SimpleSuccess_MyExampleResource() {
        final {{ operation }}HookHandler handler = new {{ operation }}HookHandler();

        final TypeConfigurationModel typeConfiguration = mock(TypeConfigurationModel.class);
        when(typeConfiguration.getEncryptionAlgorithm()).thenReturn("AES256");

        final Map<String, Object> targetModel = new HashMap<>();
        final Map<String, Object> resourceProperties = new HashMap<>();
        resourceProperties.put("MyEncryptionAlgorithm", "AES256");
        targetModel.put("ResourceProperties", resourceProperties);

        final HookHandlerRequest request = HookHandlerRequest.builder()
            .hookContext(HookContext.builder().targetName("My::Example::Resource").targetModel(HookTargetModel.of(targetModel)).build())
            .build();

        final HookProgressEvent<CallbackContext> response = handler.handleRequest(proxy, request, null, logger, typeConfiguration);

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HookStatus.SUCCESS);
        assertThat(response.getCallbackContext()).isNull();
        assertThat(response.getCallbackDelaySeconds()).isEqualTo(0);
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getErrorCode()).isNull();
    }
}
