/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.crypto.internal.asymmetric.keyfactory;

import javax.inject.Named;
import javax.inject.Singleton;

import org.bouncycastle.crypto.params.ElGamalKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.elgamal.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.xwiki.component.annotation.Component;
import org.xwiki.crypto.internal.asymmetric.BcAsymmetricKeyParameters;

/**
 * A asymmetric key factory for ElGamal keys.
 *
 * @version $Id$
 * @since 5.4M1
 */
@Component
@Named("ElGamal")
@Singleton
public class BcElGamalKeyFactory extends AbstractBcKeyFactory
{
    private AsymmetricKeyInfoConverter keyInfoConverter = new KeyFactorySpi();

    @Override
    protected AsymmetricKeyInfoConverter getKeyInfoConverter()
    {
        return this.keyInfoConverter;
    }

    @Override
    protected String checkKeyType(BcAsymmetricKeyParameters key)
    {
        if (key.getParameters() instanceof ElGamalKeyParameters) {
            return null;
        }
        return "ElGamal";
    }
}
