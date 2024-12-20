package io.xianzhi.cms.bootstrap.controller;

import io.xianzhi.boot.idempotent.annotations.Idempotent;
import io.xianzhi.cms.bootstrap.model.dto.SiteDTO;
import io.xianzhi.cms.bootstrap.model.page.SitePage;
import io.xianzhi.cms.bootstrap.model.vo.SiteVO;
import io.xianzhi.cms.bootstrap.service.SiteService;
import io.xianzhi.core.result.ListResult;
import io.xianzhi.core.result.ResponseResult;
import io.xianzhi.core.validated.CreateGroup;
import io.xianzhi.core.validated.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 站点接口
 *
 * @author Max
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/site")
public class SiteController {

    /**
     * 站点服务
     */
    private final SiteService siteService;

    /**
     * 分页查询站点列表
     *
     * @param sitePage 查询条件
     * @return 站点列表
     */
    @PreAuthorize("@xz.hasPermission('cms:site:create','cms:site:update','cms:site:deleted')")
    @PostMapping(value = "/pageSiteList")
    public ResponseResult<ListResult<SiteVO>> pageSiteList(@RequestBody SitePage sitePage) {
        return ResponseResult.success(siteService.pageSiteList(sitePage));
    }

    /**
     * 创建站点
     *
     * @param siteDTO 站点信息
     * @return 站点ID
     */
    @Idempotent
    @PreAuthorize("@xz.hasPermission('cms:site:create')")
    @PostMapping(value = "/createSite")
    public ResponseResult<String> createSite(@RequestBody @Validated(value = CreateGroup.class) SiteDTO siteDTO) {
        return ResponseResult.success(siteService.createSite(siteDTO));
    }

    /**
     * 修改站点
     *
     * @param siteDTO 站点信息
     * @return 站点ID
     */
    @PreAuthorize("@xz.hasPermission('cms:site:update')")
    @PostMapping(value = "/updateSite")
    public ResponseResult<Object> updateSite(@RequestBody @Validated(value = UpdateGroup.class) SiteDTO siteDTO) {
        siteService.updateSite(siteDTO);
        return ResponseResult.success();
    }

    /**
     * 获取站点详情
     *
     * @param siteId 站点ID
     * @return 站点详情
     */
    @PreAuthorize("@xz.hasPermission('cms:site:create','cms:site:update')")
    @GetMapping(value = "/getSiteDetails")
    public ResponseResult<SiteVO> getSiteDetails(@RequestParam(value = "siteId") String siteId) {
        return ResponseResult.success(siteService.getSiteDetails(siteId));
    }

    /**
     * 删除站点
     *
     * @param siteId 站点ID
     * @return 站点ID
     */
    @PreAuthorize("@xz.hasPermission('cms:site:deleted')")
    @PostMapping(value = "/deletedSite")
    public ResponseResult<Object> deletedSite(@RequestParam(value = "siteId") String siteId) {
        siteService.deletedSite(siteId);
        return ResponseResult.success();
    }

    /**
     * 获取当前用户站点列表
     *
     * @return 当前用户站点列表
     */
    @GetMapping(value = "/getCurrentUserSiteList")
    public ResponseResult<List<SiteVO>> getCurrentUserSiteList() {
        return ResponseResult.success(siteService.getCurrentUserSiteList());
    }
}
