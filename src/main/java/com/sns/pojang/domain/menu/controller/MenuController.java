package com.sns.pojang.domain.menu.controller;

import com.sns.pojang.domain.menu.dto.request.MenuRequest;
import com.sns.pojang.domain.menu.dto.response.MenuResponse;
import com.sns.pojang.domain.menu.service.MenuService;
import com.sns.pojang.global.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.sns.pojang.global.response.SuccessMessage.CREATE_MENU_SUCCESS;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PreAuthorize("hasRole('OWNER')")
    @PostMapping("/{storeId}/create")
    public ResponseEntity<SuccessResponse<MenuResponse>> createMenu(
            @PathVariable Long storeId, MenuRequest menuRequest){
        return ResponseEntity.created(URI.create("/create"))
                .body(SuccessResponse.create(HttpStatus.CREATED.value(),
                        CREATE_MENU_SUCCESS.getMessage(),
                        menuService.createMenu(storeId, menuRequest)));
    }
}
