package io.xianzhi.cms.bootstrap.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteDO;
import io.xianzhi.cms.bootstrap.model.dto.SiteDTO;
import io.xianzhi.cms.bootstrap.model.page.SitePage;
import io.xianzhi.cms.bootstrap.model.vo.SiteVO;
import io.xianzhi.core.result.ListResult;

import java.util.List;

/**
 * 站点接口
 *
 * @author Max
 * @since 1.0.0
 */
public interface SiteService  {
    /**
     * 分页查询站点列表
     *
     * @param sitePage 查询条件
     * @return 站点列表
     */
    ListResult<SiteVO> pageSiteList(SitePage sitePage);

    /**
     * 创建站点
     *
     * @param siteDTO 站点信息
     * @return 站点ID
     */
    String createSite(SiteDTO siteDTO);

    /**
     * 修改站点
     *
     * @param siteDTO 站点信息
     */
    void updateSite(SiteDTO siteDTO);

    /**
     * 获取站点详情
     *
     * @param siteId 站点ID
     * @return 站点详情
     */
    SiteVO getSiteDetails(String siteId);

    /**
     * 删除站点
     *
     * @param siteId 站点ID
     */
    void deletedSite(String siteId);
    /**
     * 获取当前用户站点列表
     *
     * @return 当前用户站点列表
     */
    List<SiteVO> getCurrentUserSiteList();

}
