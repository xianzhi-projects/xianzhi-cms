package io.xianzhi.cms.bootstrap.business;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.xianzhi.cms.bootstrap.dao.dataobj.SiteDO;
import io.xianzhi.cms.bootstrap.dao.mapper.SiteMapper;
import io.xianzhi.cms.bootstrap.model.code.SiteCode;
import io.xianzhi.cms.bootstrap.model.vo.SiteVO;
import io.xianzhi.cms.bootstrap.model.vo.UserVO;
import io.xianzhi.core.code.CommonCode;
import io.xianzhi.core.exception.BusinessException;
import io.xianzhi.core.result.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

/**
 * 站点业务类
 *
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SiteBusiness extends ServiceImpl<SiteMapper, SiteDO> {

    /**
     * 转换站点信息
     *
     * @param siteDO 站点信息
     * @param owner  站点Owner
     * @return 站点信息出参
     */
    public SiteVO convert(SiteDO siteDO, UserVO owner) {
        if (null == siteDO) {
            throw new BusinessException(CommonCode.PARAM_CHECK_ERROR);
        }
        SiteVO vo = new SiteVO();
        vo.setId(siteDO.getId());
        vo.setSiteName(siteDO.getSiteName());
        vo.setSiteDesc(siteDO.getSiteDesc());
        vo.setSiteDomain(siteDO.getSiteDomain());
        vo.setSiteLogo(siteDO.getSiteLogo());
        vo.setSiteFavicon(siteDO.getSiteFavicon());
        vo.setSiteRecordNo(siteDO.getSiteRecordNo());
        vo.setSiteStatus(siteDO.getSiteStatus());
        vo.setSiteSeoKeywords(siteDO.getSiteSeoKeywords());
        vo.setSiteSeoTitle(siteDO.getSiteSeoTitle());
        vo.setSiteSeoDesc(siteDO.getSiteSeoDesc());
        vo.setSiteOwner(owner);
        return vo;
    }

    /**
     * 转换站点信息
     *
     * @param siteDOList 站点信息
     * @param ownerList  owner列表
     * @return 站点信息出参
     */
    public List<SiteVO> convert(List<SiteDO> siteDOList, List<UserVO> ownerList) {
        if (ObjectUtils.isEmpty(siteDOList)) {
            throw new BusinessException(CommonCode.PARAM_CHECK_ERROR);
        }
        return siteDOList.stream().map(item -> {
            UserVO owner = ownerList.stream().filter(user -> item.getSiteOwner().equals(user.getId())).findFirst().orElse(null);
            return convert(item, owner);
        }).toList();
    }

    /**
     * 根据ID查询站点信息，不存在抛出异常
     *
     * @param siteId 站点ID
     * @return 站点信息
     */
    public SiteDO getSiteByIdOrThrow(String siteId) {
        return getSiteByIdOrThrow(siteId, SiteCode.SITE_NOT_EXIST);
    }

    /**
     * 根据ID查询站点信息，不存在抛出异常
     *
     * @param siteId 站点ID
     * @param result 异常信息
     * @return 站点信息
     */
    public SiteDO getSiteByIdOrThrow(String siteId, Result result) {
        return getSiteById(siteId).orElseThrow(() -> new BusinessException(result));
    }


    public Optional<SiteDO> getSiteById(String siteId) {
        return Optional.ofNullable(getById(siteId));
    }

}
