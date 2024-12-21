package io.xianzhi.cms.bootstrap.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xianzhi.cms.bootstrap.business.SiteBusiness;
import io.xianzhi.cms.bootstrap.business.UserBusiness;
import io.xianzhi.cms.bootstrap.context.UserContextHolder;
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteDO;
import io.xianzhi.cms.bootstrap.dao.mapper.SiteMapper;
import io.xianzhi.cms.bootstrap.dao.mapper.SiteUserMapper;
import io.xianzhi.cms.bootstrap.model.dto.SiteDTO;
import io.xianzhi.cms.bootstrap.model.page.SitePage;
import io.xianzhi.cms.bootstrap.model.vo.SiteVO;
import io.xianzhi.cms.bootstrap.model.vo.UserVO;
import io.xianzhi.cms.bootstrap.service.SiteService;
import io.xianzhi.core.result.ListResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 站点接口实现
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SiteServiceImpl implements SiteService {

    /**
     * 站点持久层
     */
    private final SiteMapper siteMapper;
    /**
     * 站点用户持久层
     */
    private final SiteUserMapper siteUserMapper;

    /**
     * 站点业务类
     */
    private final SiteBusiness siteBusiness;

    /**
     * 用户业务类
     */
    private final UserBusiness userBusiness;

    /**
     * 分页查询站点列表
     *
     * @param sitePage 查询条件
     * @return 站点列表
     */
    @Override
    public ListResult<SiteVO> pageSiteList(SitePage sitePage) {
        IPage<SiteDO> result = siteMapper.pageSiteList(new Page<>(sitePage.getPageNo(), sitePage.getPageSize()), sitePage);
        if (result.getRecords().isEmpty()) {
            return ListResult.empty();
        }
        List<SiteDO> records = result.getRecords();
        List<UserVO> owners = userBusiness.getViewUserByIds(records.stream().map(SiteDO::getSiteOwner).toList());
        return ListResult.of(siteBusiness.convert(records, owners), result.getTotal());
    }

    /**
     * 创建站点
     *
     * @param siteDTO 站点信息
     * @return 站点ID
     */
    @Override
    public String createSite(SiteDTO siteDTO) {
        return "";
    }

    /**
     * 修改站点
     *
     * @param siteDTO 站点信息
     */
    @Override
    public void updateSite(SiteDTO siteDTO) {

    }

    /**
     * 获取站点详情
     *
     * @param siteId 站点ID
     * @return 站点详情
     */
    @Override
    public SiteVO getSiteDetails(String siteId) {
        return null;
    }

    /**
     * 删除站点
     *
     * @param siteId 站点ID
     */
    @Override
    public void deletedSite(String siteId) {

    }

    /**
     * 获取当前用户站点列表
     *
     * @return 当前用户站点列表
     */
    @Override
    public List<SiteVO> getCurrentUserSiteList() {
        return siteMapper.selectSiteListByUserId(UserContextHolder.getCurrentUserId());
    }

    /**
     * 校验站点DTO
     *
     * @param siteDTO 站点DTO
     * @return 站点DO
     */
    private SiteDO checkedSiteDTO(SiteDTO siteDTO) {
        SiteDO site;
        if (StringUtils.hasText(siteDTO.getId())){
            site = siteBusiness.getSiteById(siteDTO.getId());
        }else{
            site = new SiteDO();
        }
        return null;
    }
}
