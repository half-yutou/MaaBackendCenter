package plus.maa.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.maa.backend.config.SpringDocConfig;
import plus.maa.backend.config.security.AuthenticationHelper;
import plus.maa.backend.controller.request.copilotset.CopilotSetCreateReq;
import plus.maa.backend.controller.response.MaaResult;
import plus.maa.backend.service.CopilotSetService;

/**
 * @author dragove
 * create on 2024-01-01
 */
@Tag(name = "CopilotSet", description = "作业集相关接口")
@RequestMapping("/set")
@RestController
@RequiredArgsConstructor
public class CopilotSetController {

    private final CopilotSetService service;
    private final AuthenticationHelper helper;

    @Operation(summary = "创建作业集")
    @ApiResponse(description = "作业集id")
    @SecurityRequirement(name = SpringDocConfig.SECURITY_SCHEME_NAME)
    @PostMapping("/create")
    public MaaResult<Long> createSet(
            @Parameter(description = "作业集新增请求") @RequestBody CopilotSetCreateReq req) {
        return MaaResult.success(service.create(req, helper.getUserId()));
    }

}
