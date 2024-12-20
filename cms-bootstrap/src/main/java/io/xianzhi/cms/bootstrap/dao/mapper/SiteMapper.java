package io.xianzhi.cms.bootstrap.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteDO;
import io.xianzhi.cms.bootstrap.model.page.SitePage;
import io.xianzhi.cms.bootstrap.model.vo.SiteVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 站点持久层
 *
 * @author Max
 * @since 1.0.0
 */
@Mapper
public interface SiteMapper extends BaseMapper<SiteDO> {
    /**
     * 分页查询站点列表
     *
     * @param page     分页条件
     * @param sitePage 查询条件
     * @return 站点列表
     */
    IPage<SiteDO> pageSiteList(Page<SiteDO> page, SitePage sitePage);


    /**
     * 根据用户ID查询站点列表
     *
     * @param userId 用户ID
     * @return 站点列表
     */
    List<SiteVO> selectSiteListByUserId(@Param("userId") String userId);


    /**
     * 判断站点名称是否存在
     *
     * @param siteName 站点名称
     * @param siteId   站点ID
     * @return 站点信息
     */
    boolean existsSiteBySiteNameAndIdNot(@Param("siteName") String siteName, @Param("siteId") String siteId);

    /**
     * 判断站点域名是否存在
     *
     * @param siteDomain 站点域名
     * @param siteId     站点ID
     * @return 是否存在
     */
    boolean existsSiteBySiteDomainAndIdNot(@Param("siteDomain") String siteDomain, @Param("siteId") String siteId);
}
